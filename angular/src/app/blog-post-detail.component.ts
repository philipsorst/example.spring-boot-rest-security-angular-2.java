import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {BlogService} from "./blog.service";
import {BlogPost} from "./blogpost";
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'blog-post-detail',
  templateUrl: 'blog-post-detail.component.html'
})
export class BlogPostDetailComponent implements OnInit {

  blogPost: BlogPost;

  constructor(private route: ActivatedRoute, private blogService: BlogService) {
  }

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.blogService.findBlogPost(+params.get('id')))
      .subscribe(blogPost => this.blogPost = blogPost);
  }
}
