import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MenuTemplateComponent} from '../../menu/menu-template/menu-template.component';
import {StudentRegistrationComponent} from './student-registration/student-registration.component';

const routes: Routes = [
  {
    path: '',
    component: StudentRegistrationComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRegistrationRoutingModule { }
