import { ITeam, NewTeam } from './team.model';

export const sampleWithRequiredData: ITeam = {
  id: 88024,
};

export const sampleWithPartialData: ITeam = {
  id: 93990,
  city: 'Shieldshaven',
};

export const sampleWithFullData: ITeam = {
  id: 7800,
  name: 'invoice CSS Developer',
  city: 'North Torey',
};

export const sampleWithNewData: NewTeam = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
