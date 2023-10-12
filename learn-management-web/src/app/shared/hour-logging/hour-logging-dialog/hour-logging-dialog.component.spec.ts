import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HourLoggingDialogComponent } from './hour-logging-dialog.component';

describe('HourLoggingDialogComponent', () => {
  let component: HourLoggingDialogComponent;
  let fixture: ComponentFixture<HourLoggingDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HourLoggingDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HourLoggingDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
