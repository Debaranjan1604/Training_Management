import { TestBed, async, inject } from '@angular/core/testing';

import { AdminloginauthGuard } from './adminloginauth.guard';

describe('AdminloginauthGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminloginauthGuard]
    });
  });

  it('should ...', inject([AdminloginauthGuard], (guard: AdminloginauthGuard) => {
    expect(guard).toBeTruthy();
  }));
});
