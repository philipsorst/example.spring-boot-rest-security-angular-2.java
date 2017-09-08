import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {BlogPost} from "./blogpost";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class BlogService {

  constructor(private http: Http) {
  }

  findBlogPost(id: number): Promise<BlogPost> {
    return this.http.get('api/posts/' + id)
      .toPromise()
      .then(response => response.json() as BlogPost)
      .catch(this.handleError);
  }

  listBlogPosts(): Promise<BlogPost[]> {
    return this.http.get('api/posts')
      .toPromise()
      .then(response => response.json()._embedded.blogPosts as BlogPost[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
