import {Component, OnInit} from '@angular/core';
import {BlogService} from "./blog.service";
import {BlogPost} from "./blogpost";

@Component({
  selector: 'blog-post-list',
  templateUrl: 'blog-post-list.component.html',
  providers: [BlogService]
})
export class BlogPostListComponent implements OnInit {

  blogPosts: BlogPost[] = [];

  constructor(private blogService: BlogService) {
  }

  ngOnInit(): void {
    this.blogService.listBlogPosts().then(blogPosts => this.blogPosts = blogPosts);
  }
}
