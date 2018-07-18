new Vue({
    el: '#root',
    data : {
        posts: []
    },
    mounted(){
        this.fetchPosts();
    },
    methods: {
        fetchPosts(){
            axios.get("/index")
                .then(function(response) {
                    this.posts = response.data;
            }.bind(this));
        }
    }
});