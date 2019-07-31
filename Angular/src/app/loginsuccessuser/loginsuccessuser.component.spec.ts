import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginsuccessuserComponent } from './loginsuccessuser.component';

describe('LoginsuccessuserComponent', () => {
  let component: LoginsuccessuserComponent;
  let fixture: ComponentFixture<LoginsuccessuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginsuccessuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginsuccessuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
