import {templateHtml} from './html/PostHtml'

const baseUrl = "http://localhost:8080";

export const Post = {
    name: 'post',
    template: templateHtml,
    data: () => ({
        post: null
    }),
    mounted() {
        this.getPosts();
    },
    methods: {
        getPosts() {
            var id = this.$route.params.id;
            axios.get(baseUrl + `/api/` + id).then(response => {
                this.post = response.data
            }).catch(error => {
                console.log(error);
            })
        }
    }
};