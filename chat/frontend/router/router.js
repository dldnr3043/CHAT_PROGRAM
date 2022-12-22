import { createWebHistory, createRouter } from "vue-router";

import LoginPage from "@/components/login/Login.vue"

const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 component를 추가한다.
        { path : "/chat/web/login", name : "LoginPage", component : LoginPage },
    ]
});

export default router;