const baseUrl = "http://localhost:8080";
const templateHtml = "<div>" +
                         "<router-link :to=\"{ name: 'homepage' }\">Homepage</router-link>" +
                          "<h3>{{post.title}}</h3>" +
                          "{{post.body}}" +
                      "</div>";
// Post component
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