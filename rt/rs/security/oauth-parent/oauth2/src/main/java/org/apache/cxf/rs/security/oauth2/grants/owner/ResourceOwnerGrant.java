/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.rs.security.oauth2.grants.owner;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.apache.cxf.rs.security.oauth2.common.AccessTokenGrant;
import org.apache.cxf.rs.security.oauth2.utils.OAuthConstants;

public class ResourceOwnerGrant implements AccessTokenGrant {
    private String ownerName;
    private String ownerPassword;
    private String scope;
    
    public ResourceOwnerGrant(String name, String password) {
        this(name, password, null);
    }
    
    public ResourceOwnerGrant(String name, String password, String scope) {
        this.ownerName = name;
        this.ownerPassword = password;
        this.scope = scope;
    }
    
    public String getType() {
        return OAuthConstants.RESOURCE_OWNER_GRANT;
    }

    public MultivaluedMap<String, String> toMap() {
        MultivaluedMap<String, String> map = new MetadataMap<String, String>();
        map.putSingle(OAuthConstants.GRANT_TYPE, OAuthConstants.RESOURCE_OWNER_GRANT);
        map.putSingle(OAuthConstants.RESOURCE_OWNER_NAME, ownerName);
        map.putSingle(OAuthConstants.RESOURCE_OWNER_PASSWORD, ownerPassword);
        if (scope != null) {
            map.putSingle(OAuthConstants.SCOPE, scope);
        }
        return map;
    }

}