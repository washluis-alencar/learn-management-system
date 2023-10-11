import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'student-registration',
    loadChildren: () => import('./features/student-registration/student-registration.module').then((m) => m.StudentRegistrationModule),
  },
  {
    path: 'course-administration',
    loadChildren: () => import('./features/course-administration/course-administration.module').then((m) => m.CourseAdministrationModule),
  },
  {
    path: 'learning-progress',
    loadChildren: () => import('./features/learning-progress/learning-progress.module').then((m) => m.LearningProgressModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
