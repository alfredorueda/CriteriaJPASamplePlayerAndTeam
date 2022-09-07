import dayjs from 'dayjs/esm';
import { ITeam } from 'app/entities/team/team.model';

export interface IPlayer {
  id: number;
  name?: string | null;
  birthDate?: dayjs.Dayjs | null;
  height?: number | null;
  weight?: number | null;
  baskets?: number | null;
  assists?: number | null;
  team?: Pick<ITeam, 'id' | 'name'> | null;
}

export type NewPlayer = Omit<IPlayer, 'id'> & { id: null };
