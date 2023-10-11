import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseAdministrationRoutingModule } from './course-administration-routing.module';
import { CourseAdministrationComponent } from './course-administration/course-administration.component';


@NgModule({
  declarations: [CourseAdministrationComponent],
  imports: [
    CommonModule,
    CourseAdministrationRoutingModule
  ]
})
export class CourseAdministrationModule { }
