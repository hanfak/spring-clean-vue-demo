   // base Url of the API
   // uncomment and replace if want to access 3rd party endpoint over internet
//    const baseUrl = "http://jsonplaceholder.typicode.com";
    const baseUrl = "http://localhost:8080";

    // List component
    const List = {
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
                // uncomment and replace if want to access 3rd party endpoint over internet
//                axios.get(baseUrl + `/posts`).then(response => {
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

    // Post component
    const Post = {
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
                // uncomment and replace if want to access 3rd party endpoint over internet
//                axios.get(baseUrl + `/posts/` + id).then(response => {
                axios.get(baseUrl + `/api/` + id).then(response => {
                    this.post = response.data
                }).catch(error => {
                    console.log(error);
                })
            }
        }
    };

    // Create vue router
    var router = new VueRouter({
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

    // Create vue instance with our router, and mount onto #app
    var vue = new Vue({router});
    var app = vue.$mount('#app');