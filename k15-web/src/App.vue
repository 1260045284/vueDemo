<template>
    <div id="app">
        <!--主路由-->
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'app',
    }
</script>

<style>
    * {
        margin: 0;
        padding: 0;
    }

    html,
    body,
    #app {
        width: 100%;
        height: 100%;
    }
</style>
