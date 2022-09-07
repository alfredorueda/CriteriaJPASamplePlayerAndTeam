import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IPlayer, NewPlayer } from '../player.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IPlayer for edit and NewPlayerFormGroupInput for create.
 */
type PlayerFormGroupInput = IPlayer | PartialWithRequiredKeyOf<NewPlayer>;

type PlayerFormDefaults = Pick<NewPlayer, 'id'>;

type PlayerFormGroupContent = {
  id: FormControl<IPlayer['id'] | NewPlayer['id']>;
  name: FormControl<IPlayer['name']>;
  birthDate: FormControl<IPlayer['birthDate']>;
  height: FormControl<IPlayer['height']>;
  weight: FormControl<IPlayer['weight']>;
  baskets: FormControl<IPlayer['baskets']>;
  assists: FormControl<IPlayer['assists']>;
  team: FormControl<IPlayer['team']>;
};

export type PlayerFormGroup = FormGroup<PlayerFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class PlayerFormService {
  createPlayerFormGroup(player: PlayerFormGroupInput = { id: null }): PlayerFormGroup {
    const playerRawValue = {
      ...this.getFormDefaults(),
      ...player,
    };
    return new FormGroup<PlayerFormGroupContent>({
      id: new FormControl(
        { value: playerRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      name: new FormControl(playerRawValue.name),
      birthDate: new FormControl(playerRawValue.birthDate),
      height: new FormControl(playerRawValue.height),
      weight: new FormControl(playerRawValue.weight),
      baskets: new FormControl(playerRawValue.baskets),
      assists: new FormControl(playerRawValue.assists),
      team: new FormControl(playerRawValue.team),
    });
  }

  getPlayer(form: PlayerFormGroup): IPlayer | NewPlayer {
    return form.getRawValue() as IPlayer | NewPlayer;
  }

  resetForm(form: PlayerFormGroup, player: PlayerFormGroupInput): void {
    const playerRawValue = { ...this.getFormDefaults(), ...player };
    form.reset(
      {
        ...playerRawValue,
        id: { value: playerRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): PlayerFormDefaults {
    return {
      id: null,
    };
  }
}
