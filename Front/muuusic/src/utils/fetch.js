import { axios } from '@/utils/request'
export function getSomeDataApi(parameter) {
  return axios({
    url: '/detail',
    method: 'get',
    params: parameter
  })

 }

