package com.careerit.lsdata.util;

import java.util.UUID;

public class UserContextUtil {

        private static final String userId = "9cf72bed-9757-46ab-8514-6287fff46439";

        public static UUID getLoginUserId() {
             return UUID.fromString(userId);
        }
}
