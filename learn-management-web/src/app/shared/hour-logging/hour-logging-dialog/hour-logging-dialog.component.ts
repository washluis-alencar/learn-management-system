import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-hour-logging-dialog',
  templateUrl: './hour-logging-dialog.component.html',
  styleUrls: ['./hour-logging-dialog.component.scss']
})
export class HourLoggingDialogComponent implements OnInit {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<HourLoggingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.form = this.fb.group({
      logDate: [data.logDate],
      time: [data.time]
    });
  }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
