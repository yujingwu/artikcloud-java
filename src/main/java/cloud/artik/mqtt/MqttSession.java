/*
 * Copyright (C) 2018 Samsung Electronics Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cloud.artik.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * This class provide the basic MQTT pub/sub
 * functionalities using the Paho MQTT library.
 * 
 * It uses non-blocking methods to talk to ARTIK Cloud
 * MQTT server. Such an operation runs in the background.
 * 
 * The MQTT client ID uses ARTIK Cloud device ID.
 */
public class MqttSession {
    private final static String PUBLISH_TOPIC_BASE    = "/v1.1/messages/";
    private final static String SUBSCRIBE_TOPIC_BASE  = "/v1.1/actions/";
    private final static String SCHEME                = "ssl";
    private final static String HOST                  = "api.artik.cloud";
    private final static String PORT                  = "8883";

    private MqttAsyncClient mqttClient;
    private OperationListener operationListener;
    private MessageListener msgListener;
    private String deviceId;
    private String deviceToken;
    private String publishTopic;
    private String subscribeTopic;
    private String brokerUri;
    
    /**
     * 
     * @param deviceId ARTIK Cloud device ID
     * @param deviceToken ARTIK Cloud device token
     * @param msgCallback callback handling events such as receiving message from the topic subscribing to
     * @param userCallback callback handling mqtt operations such as connect/disconnect/publish/subscribe et al.
     * @throws ArtikCloudMqttException
     */
    public MqttSession(String deviceId,
    		String deviceToken,
    		ArtikCloudMqttCallback callback
    	) throws ArtikCloudMqttException {
    	this.operationListener = new OperationListener(callback);
    	this.deviceId = deviceId;
    	this.deviceToken = deviceToken;
    	
    	this.brokerUri = SCHEME + "://" + HOST + ":" + PORT; 
    	this.publishTopic = PUBLISH_TOPIC_BASE + deviceId;
    	this.subscribeTopic = SUBSCRIBE_TOPIC_BASE + deviceId;
    	
        try {
            mqttClient = new MqttAsyncClient(brokerUri, deviceId, new MemoryPersistence());
            msgListener = new MessageListener(callback);
            mqttClient.setCallback(msgListener);
        } catch (MqttException e) {
            throw new ArtikCloudMqttException(e);
        }
    }
    
    public void connect() throws ArtikCloudMqttException {
        try {
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(deviceId);
            connOpts.setPassword(deviceToken.toCharArray());
//            System.out.println("****** Thread: " + Thread.currentThread().getName()+ "; MqttSession connecting to : "+ brokerUri);
            
            mqttClient.connect(connOpts, String.valueOf(OperationMode.CONNECT), operationListener);
        } catch (Exception e) {
            throw new ArtikCloudMqttException(e);
        }
    	
    }
    
    public void disconnect() throws ArtikCloudMqttException {
        try {
//            System.out.println("****** Thread: " + Thread.currentThread().getName()+ "; MqttSession disconnecting to : "+ brokerUri);
        	mqttClient.disconnect(0, String.valueOf(OperationMode.DISCONNECT), operationListener);
        } catch (MqttException e) {
            throw new ArtikCloudMqttException(e);
        }
    }

    /**
     * 
     * @param qos Quality of Service (0, 1, or 2) used for publishing a message to ARTIK Cloud
     * @param payload the payload of the published message
     * @throws ArtikCloudMqttException
     */
    public void publish(int qos, String payload) throws ArtikCloudMqttException {
        MqttMessage mqttMessage = new MqttMessage(payload.getBytes());
        mqttMessage.setQos(qos);
//        System.out.println("****** Thread: " + Thread.currentThread().getName()+ "; MqttSession publishing : "+ "topic: " + publishTopic +"; payload: " + payload);
        try {
            mqttClient.publish(publishTopic, mqttMessage, String.valueOf(OperationMode.PUBLISH), operationListener);
        } catch (MqttException e) {
        	throw new ArtikCloudMqttException(e);
        }
    }
    
    public void subscribe() throws ArtikCloudMqttException {
        try {
//            System.out.println("****** Thread: " + Thread.currentThread().getName()+ "; MqttSession subscribing to:" + subscribeTopic);

        	// When sending Actions back to the client, ARTIK Cloud broker uses QoS 0, which is also called "fire and forget".
        	// Given this, the subscriber can only use QoS 0 to subscribe to ARTIK Cloud broker
        	mqttClient.subscribe(subscribeTopic, 0, String.valueOf(OperationMode.SUBSCRIB), operationListener);
        } catch (MqttException e) {
        	throw new ArtikCloudMqttException(e);
        }
    	
    }
    
    public boolean isConnected() {
    	return mqttClient.isConnected();
    }
    
    public String getPublishTopic() {
    	return publishTopic;
    }

    public String getBrokerUri() {
    	return brokerUri;
    }

    public String getSubscribeTopic() {
    	return subscribeTopic;
    }
    
    ////////////////////////////////////////////////////////////////
    //
    //     Private helpers
    //
    ////////////////////////////////////////////////////////////////
   
    /**
     * This class implements listener functions of the operation events from the
     * Paho MQTT library. It is a wrapper.
     * 
     * Once a method of this class (onSuccess or onFailure) is called, it calls the 
     * corresponding method from ArtikCloudMqttCallback in a separate thread. 
     * In this way, this method returns quickly. Otherwise the operation of the 
     * MQTT client will be stalled.
     * 
     * OperationMode class document the operations that OperationListener is listening to.
     */
    private class OperationListener implements IMqttActionListener {
    	ArtikCloudMqttCallback userCallback;

    	OperationListener(ArtikCloudMqttCallback callback) {
    		this.userCallback = callback;
    	}
    	
    	@Override
    	public void onFailure(final IMqttToken arg0, final Throwable arg1) {
     		if (userCallback == null) {
     			return;
     		}
     		
     		Thread t = new Thread(new Runnable() {
    	         @Override
    	         public void run() {
    	             OperationMode opMode = getOperationModeFromContext((String)arg0.getUserContext());
    	        	 userCallback.onFailure(opMode, arg0, arg1);
    	         }
    	     });
    		t.start();
    	}

    	@Override
    	public void onSuccess(final IMqttToken arg0) {
//            System.out.println("-------- Thread: " + Thread.currentThread().getName()+ "; MqttSession.OperationListener onSuccess: ");
     		if (userCallback == null) {
     			return;
     		}

    		Thread t = new Thread(new Runnable() {
    	         @Override
    	         public void run() {
    	        	 OperationMode opMode = getOperationModeFromContext((String)arg0.getUserContext());
    	        	 userCallback.onSuccess(opMode, arg0);
    	         }
    	     });
    		t.start();
    	}
    	
    	private OperationMode getOperationModeFromContext(String userContext) {
     		OperationMode mode = OperationMode.UNKNOWN;

     		if (userContext.equals(String.valueOf(OperationMode.CONNECT))) {
     			mode = OperationMode.CONNECT;
     		} else if (userContext.equals(String.valueOf(OperationMode.DISCONNECT))) {
     			mode = OperationMode.DISCONNECT;
     		} else if (userContext.equals(String.valueOf(OperationMode.PUBLISH))) {
     			mode = OperationMode.PUBLISH;
     		} else if (userContext.equals(String.valueOf(OperationMode.SUBSCRIB))) {
     			mode = OperationMode.SUBSCRIB;
     		}
     		
     		return mode;
    	}

    }
    
    /**
     * This class implements listener functions of asynchronous
     * events related to the MqttAsyncClient from Paho library.
     * It is a wrapper.
     * 
     * Once a method of this class is called, it calls the 
     * corresponding method from ArtikCloudMqttCallback in a separate thread. 
     * In this way, this method returns quickly. Otherwise the operation of the 
     * MQTT client will be stalled.
     * 
     * This class listens to the following events:
     *    - lost the connection with the server
     *    - complete delivering a message to the server
     *    - receive a message from the server
     *    
     */
    private class MessageListener implements MqttCallback {
    	ArtikCloudMqttCallback userCallback;

    	MessageListener(ArtikCloudMqttCallback callback) {
    		this.userCallback = callback;
    	}

    	@Override
    	public void connectionLost(final Throwable cause) {
     		if (userCallback == null) {
     			return;
     		}

    		Thread t = new Thread(new Runnable() {
    	         @Override
    	         public void run() {
    	        	 userCallback.connectionLost(cause);
    	         }
    	     });
    		t.start();
    	}

   		

    	@Override
    	public void deliveryComplete(final IMqttDeliveryToken mqttDelToken) {
     		if (userCallback == null) {
     			return;
     		}

    		Thread t = new Thread(new Runnable() {
    	         @Override
    	         public void run() {
    	        	 userCallback.deliveryComplete(mqttDelToken);
    	         }
    	     });
    		t.start();
    	
     	}

    	@Override
    	public void messageArrived(final String fromTopic, final MqttMessage mqttMessage) {
 //           System.out.println("-------- Thread: " + Thread.currentThread().getName()+ "; MqttSession.MessageListener messageArrived: " + mqttMessage);
      		if (userCallback == null) {
     			return;
     		}

    		Thread t = new Thread(new Runnable() {
    	         @Override
    	         public void run() {
    	        	 userCallback.messageArrived(fromTopic, mqttMessage);
    	         }
    	     });
    		t.start();
    	}
    }

}