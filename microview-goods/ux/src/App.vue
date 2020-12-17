<template>
  <v-data-table
          :headers="headers"
          :items="goods"
          :loading="loading"
          :search="search"
          class="elevation-1"
  >
    <!-- 数据表格 头部插槽配置 -->
    <template v-slot:top>
      <v-toolbar flat color="white">
        <v-toolbar-title>物品管理</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-text-field
                v-model="search"
                append-icon="fa-search"
                class="mr-5"
                label="搜索"
                single-line
                hide-details
        ></v-text-field>
        <v-btn color="primary" dark class="mb-2" @click="editDialog=true">添加物品</v-btn>
        <v-dialog v-model="editDialog" persistent max-width="500px">
          <v-card :loading="loading">
            <v-card-title>
              <span class="headline">添加物品</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12">
                    <v-text-field v-model="editGoods.id"
                                  label="ID"></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field v-model="editGoods.name"
                                  label="名称"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="editDialog = false">取消</v-btn>
              <v-btn color="primary darken-1" @click="save">保存</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <!-- 数据表格 操作部分配置 -->
    <template v-slot:item.actions="{  }">
      <v-btn small color="blue" outlined @click="editDialog = true">详情</v-btn>
    </template>
    <!-- 数据表格 无数据状态展示 -->
    <template v-slot:no-data>
      <v-btn small text outlined>
        暂无数据, 点击刷新
      </v-btn>
    </template>
  </v-data-table>
</template>

<script>
  export default {
    name: 'microview-goods',

    data: () => ({
      loading: false,
      editDialog: false,
      search: "",
      headers: [
        {
          text: '序号',
          align: 'start',
          sortable: false,
          value: 'id',
        },
        {
          text: '名称',
          sortable: false,
          value: 'name',
        },
        {
          text: '操作',
          sortable: false,
          value: 'actions'
        },
      ],
      goods: [],
      editGoods: {},
    }),
    mounted() {
      let vm = this
      this.loading = true
      this.$axios.get('/goods/list', {}).then(response => {
        if (response.status === 200 && response.data) {
          vm.goods = response.data
        }
      }).finally(() => {
        this.loading = false
      })
    },
    methods: {
      save() {
        let vm = this
        this.loading = true
        this.$axios.post('/goods/add', this.editGoods).then(response => {
          if (response.status === 200 && response.data) {
            vm.goods.splice(0,0, response.data)
            vm.editGoods = {}
          }
          vm.editDialog = false
          vm.loading = false
        }).finally(() => {
          this.loading = false
        })
      }
    },
  }
</script>
