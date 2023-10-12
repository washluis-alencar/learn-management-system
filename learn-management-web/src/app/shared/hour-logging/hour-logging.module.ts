import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HourLoggingDialogComponent } from './hour-logging-dialog/hour-logging-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [HourLoggingDialogComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatButtonModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    HourLoggingDialogComponent
  ],
  exports: [
    HourLoggingDialogComponent
  ]
})
export class HourLoggingModule { }
