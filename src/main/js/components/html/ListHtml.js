export const templateHtml = `<div class="row">
                          <input class="col-sm-4" v-model="search" placeholder="Enter search terms">
                          <div class="col-sm-8">
                              <p>Displaying {{ filteredPosts.length }} posts, filtered by <strong>{{ search }}</strong></p>
                              <p>{{ word() }}</p>
                              <ul>
                                  <li v-for="post in filteredPosts">
                                      <router-link :to="{ name: 'post', params: { id: post.id }}">
                                          {{post.title}}
                                      </router-link>
                                  </li>
                              </ul>
                          </div>
                      </div>`