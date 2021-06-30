package petrolStation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**    Этот класс имеет поле содержащее информацию о
 * сумме внесенных клиентом денег. По сути выполняя
 * функцию кассы, этот класс сериализоваться или
 * записываться в базу данных не будет
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Manager {
    private int payment;
}
