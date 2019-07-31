import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursestatusComponent } from './coursestatus.component';

describe('CoursestatusComponent', () => {
  let component: CoursestatusComponent;
  let fixture: ComponentFixture<CoursestatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursestatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursestatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
