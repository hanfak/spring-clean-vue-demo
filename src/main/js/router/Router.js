import {List} from '../components/List'
import {Post} from '../components/Post'

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            name: 'homepage',
            path: '/',
            component: List
        }, {
            name: 'post',
            path: '/:id',
            component: Post
        }
    ]
});