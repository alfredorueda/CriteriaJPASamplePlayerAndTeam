export interface ITeam {
  id: number;
  name?: string | null;
  city?: string | null;
}

export type NewTeam = Omit<ITeam, 'id'> & { id: null };
