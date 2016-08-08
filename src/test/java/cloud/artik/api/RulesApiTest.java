/**
 * ARTIK Cloud API
 * 
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package cloud.artik.api;

import cloud.artik.client.ApiException;
import cloud.artik.model.RuleEnvelope;
import cloud.artik.model.RuleCreationInfo;
import cloud.artik.model.RuleUpdateInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RulesApi
 */
public class RulesApiTest {

    private final RulesApi api = new RulesApi();

    
    /**
     * Create Rule
     *
     * Create a new Rule
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createRuleTest() throws ApiException {
        RuleCreationInfo ruleInfo = null;
        String userId = null;
        // RuleEnvelope response = api.createRule(ruleInfo, userId);

        // TODO: test validations
    }
    
    /**
     * Delete Rule
     *
     * Delete a Rule
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteRuleTest() throws ApiException {
        String ruleId = null;
        // RuleEnvelope response = api.deleteRule(ruleId);

        // TODO: test validations
    }
    
    /**
     * Get Rule
     *
     * Get a rule using the Rule ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRuleTest() throws ApiException {
        String ruleId = null;
        // RuleEnvelope response = api.getRule(ruleId);

        // TODO: test validations
    }
    
    /**
     * Update Rule
     *
     * Update an existing Rule
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateRuleTest() throws ApiException {
        String ruleId = null;
        RuleUpdateInfo ruleInfo = null;
        // RuleEnvelope response = api.updateRule(ruleId, ruleInfo);

        // TODO: test validations
    }
    
}
