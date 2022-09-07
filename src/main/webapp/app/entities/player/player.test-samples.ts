import dayjs from 'dayjs/esm';

import { IPlayer, NewPlayer } from './player.model';

export const sampleWithRequiredData: IPlayer = {
  id: 92110,
};

export const sampleWithPartialData: IPlayer = {
  id: 22348,
  name: 'Cedi',
  height: 8595,
  weight: 97222,
  assists: 47305,
};

export const sampleWithFullData: IPlayer = {
  id: 63886,
  name: 'synthesizing hard',
  birthDate: dayjs('2022-09-07'),
  height: 23533,
  weight: 60451,
  baskets: 5754,
  assists: 39436,
};

export const sampleWithNewData: NewPlayer = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
