const baseUrl = "http://localhost:8080";

// List component
export const List = {
    template: '#list-template',
    data: () => ({
        posts: [],
        search: ""
    }),
    mounted() {
        this.getPosts();
    },
    methods: {
        getPosts() {
            axios.get(baseUrl + `/api`).then(response => {
                this.posts = response.data;
                console.log(this.posts);
            }).catch(error => {
                console.log(error);
            })
        },
        word() {
            return "bye bye";
        }
    },
    computed: {
        filteredPosts() {
          return this.posts.filter(post => {
             return post.title.includes(this.search);
          })
        }
    }
};
