import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms'
import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {BlogPostDetailComponent} from "./blog-post-detail.component";
import {BlogPostListComponent} from "./blog-post-list.component";
import {BlogService} from "./blog.service";
import {HttpModule} from "@angular/http";


@NgModule({
  declarations: [
    AppComponent,
    BlogPostDetailComponent,
    BlogPostListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [
    BlogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
