const baseUrl = "http://localhost:8080";

// Post component
export const Post = {
    template: '#post-template',
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