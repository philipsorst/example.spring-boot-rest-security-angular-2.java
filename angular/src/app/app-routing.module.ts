import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {BlogPostDetailComponent} from "./blog-post-detail.component";
import {BlogPostListComponent} from "./blog-post-list.component";

const routes: Routes = [
  {path: '', component: BlogPostListComponent},
  {path: ':id', component: BlogPostDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
