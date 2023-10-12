import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LearningProgressComponent} from './learning-progress/learning-progress.component';

const routes: Routes = [
  {
    path: '',
    component: LearningProgressComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LearningProgressRoutingModule { }
