import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuTemplateComponent } from './menu-template/menu-template.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {RouterModule} from '@angular/router';



@NgModule({
  declarations: [MenuTemplateComponent],
  imports: [
    CommonModule,
    MatProgressBarModule,
    RouterModule
  ]
})
export class MenuModule { }
