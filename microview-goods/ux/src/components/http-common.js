import axios from 'axios'
import Vue from 'vue'
import HttpStatus from 'http-status'

let instance = axios.create({
  baseURL: 'http://localhost:8081'
})

instance.interceptors.request.use(config => {
  let token = sessionStorage.getItem('token')
  if (token) {
    config.headers.Token = token
  }
  return config
})

instance.interceptors.response.use((response) => {
  let token = response.headers.token
  sessionStorage.setItem('token', token)
  return response
}, (error) => {
  if (error.message.indexOf('Network Error') >= 0) {
    Vue.prototype.$notify.error('Network error, please check your network settings!')
  } else if (error.response.status === HttpStatus.UNAUTHORIZED) {
    sessionStorage.removeItem('token')
    sessionStorage.removeItem('uname')
    sessionStorage.removeItem('user')
    Vue.prototype.$notify.error('Authorized failed,please login.')
  } else if (error.response.status >= HttpStatus.BAD_REQUEST) {
    Vue.prototype.$notify.error(error.response.data.message)
  }
})

export const AXIOS = instance
