<template>
    <v-app id="inspire">
        <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" app color="blue darken-3" dark>
            <v-toolbar-title style="width: 300px" class="ml-0 pl-4">
                <span class="hidden-sm-and-down">MicroView</span>
            </v-toolbar-title>
            <v-text-field
                    flat
                    solo-inverted
                    hide-details
                    prepend-inner-icon="fa-search"
                    label="搜索"
                    class="hidden-sm-and-down"
            ></v-text-field>
            <v-spacer></v-spacer>
            <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn text v-on="on">{{currapp.title}}</v-btn>
                </template>

                <v-list>
                    <v-list-item v-for="(app, i) in apps" :key="i" @click="goto(app)">
                        <v-list-item-icon>
                            <v-icon v-text="app.icon"></v-icon>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title v-text="app.title"></v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-menu>

        </v-app-bar>
        <v-main>
            <v-container class="fill-height" fluid>
                <div id="appContainer" style="width:100%;height:100%;"/>
            </v-container>
        </v-main>
        <v-footer color="blue darken-3" app>
            <span class="white--text">&copy; 2020</span>
        </v-footer>
        <v-dialog
                v-model="loading"
                hide-overlay
                persistent
                width="300"
        >
            <v-card
                    color="primary"
                    dark
            >
                <v-card-text>
                    加载中...
                    <v-progress-linear
                            indeterminate
                            color="white"
                            class="mb-0"
                    ></v-progress-linear>
                </v-card-text>
            </v-card>
        </v-dialog>
    </v-app>
</template>

<script>
    import {
        registerMicroApps,
        runAfterFirstMounted,
        setDefaultMountApp,
        start,
    } from "qiankun";

    export default {
        data: () => ({
            apps: [],
            currapp:{},
            loading: false,
            uname: "",
        }),
        mounted() {
            this.uname = sessionStorage.getItem("uname")
            if(this.uname){
                sessionStorage.setItem("uname", "test")
                this.uname = "test"
            }
        },
        created() {
            let vm = this
            this.$axios.get('/', {}).then(response => {
                if (response.status === 200 && response.data) {
                    vm.apps = response.data
                    if (!window.__INJECTED_PUBLIC_PATH_BY_QIANKUN__) {
                        this.initQiankun()
                    } else {
                        // fix hot-reload
                        location.reload()
                    }
                }
            }).finally(() => {
            })
        },
        methods: {
            goto(app) {
                this.currapp = app
                window.history.pushState({}, this.currapp.title, this.currapp.activeRule);
            },
            initQiankun() {
                registerMicroApps(this.apps, {
                    beforeLoad: [
                        (app) => {
                            // eslint-disable-next-line no-console
                            console.log("before load", app);
                        },
                    ],
                    beforeMount: [
                        (app) => {
                            // eslint-disable-next-line no-console
                            console.log("before mount", app);
                        },
                    ],
                    afterUnmount: [
                        (app) => {
                            // eslint-disable-next-line no-console
                            console.log("after unload", app);
                        },
                    ],
                });

                this.currapp = this.apps[0]

                setDefaultMountApp(this.currapp.activeRule);

                runAfterFirstMounted(() => {
                    // eslint-disable-next-line no-console
                    console.info("first app mounted");
                });

                start({ prefetch: true });
            },
        },
    };
</script>