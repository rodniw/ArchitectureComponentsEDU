package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.utils.Address;

import static android.arch.persistence.room.ColumnInfo.TEXT;

//В этом случае база будет следить,
// чтобы в этой таблице не было записи с повторящейся парой значений first_name и last_name.
@Entity(
        tableName = "employees",
        indices = {@Index(value = {"full_name", "last_name"}, unique = false)}
)
public class Employee {

    //autoincrement of the primary key
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "full_name", typeAffinity = TEXT)
    public String name;

    @ColumnInfo(name = "last_name")
    public String lastName;

    //Аннотация Ignore позволяет подсказать Room, что это поле не должно записываться в базу или читаться из нее.
    @Ignore
    public Bitmap avatar;

    public int salary;

    //Embedded подскажет Room, что надо просто взять поля из Address и считать их полями таблицы Employee.
    //Если у вас получается так,
    //что совпадают имена каких-то полей в основном объекте и в Embedded объекте,
    //то используйте префикс для Embedded объекта.
    @Embedded(prefix = "address")
    public Address address;
}

//Чтобы Room мог добраться до полей класса Entity, мы делаем их public.
//Но есть возможность использовать private поля. Для этого надо добавить set/get методы.
//Вместо set-методов мы также можем использовать конструктор.

/*    Чтобы создать составной ключ - primaryKeys.

    @Entity(primaryKeys = {"key1", "key2"})
    public class Item {

        public long key1;
        public long key2;

        // ...

    }
*/

//Индекс дает возможность установить для его полей проверку на уникальность. Это делается параметром unique = true.
