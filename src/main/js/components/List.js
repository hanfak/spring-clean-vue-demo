const baseUrl = "http://localhost:8080";
const templateHtml = `<div>
                          <input v-model="search" placeholder="Enter search terms">
                          <p>Displaying {{ filteredPosts.length }} posts, filtered by <strong>{{ search }}</strong></p>
                          <p>{{ word() }}</p>
                          <ul>
                              <li v-for="post in filteredPosts">
                                  <router-link :to="{ name: 'post', params: { id: post.id }}">
                                      {{post.title}}
                                  </router-link>
                              </li>
                          </ul>
                      </div>`

// List component
export const List = {
    name: 'list',
    template: templateHtml,
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
