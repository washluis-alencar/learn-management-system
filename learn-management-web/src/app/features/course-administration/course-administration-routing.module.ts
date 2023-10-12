import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CourseAdministrationComponent} from './course-administration/course-administration.component';

const routes: Routes = [
  {
    path: '',
    component: CourseAdministrationComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseAdministrationRoutingModule { }
