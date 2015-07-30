/*
 Copyright 2014 Microsoft Open Technologies, Inc.
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.microsoftopentechnologies.azure.util;

import com.microsoft.aad.adal4j.AuthenticationResult;

public class TokenCache {

    private AccessToken token = null;

    public AccessToken get() {
        if (token != null && token.isExpiring()) {
            token = null;
        }

        return token;
    }

    public AccessToken set(final AuthenticationResult authres) {
        token = AccessToken.load(authres);
        return token;
    }
}
