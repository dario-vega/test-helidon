/*
 *  Copyright (c) 2024 Contributors to the Eclipse Foundation
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   and Apache License v2.0 which accompanies this distribution.
 *   The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *   and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 *   You may elect to redistribute this code under either of these licenses.
 *
 *   Contributors:
 *
 *   Otavio Santana
 */
package os.expert.demo.helidon;


import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import javassist.expr.FieldAccess;
import net.datafaker.Faker;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


@Entity
@JsonbVisibility(FieldAccessStrategy.class)
public class Beer {

    @Id
    private String id;

    @Column
    private String style;

    @Column
    private String hop;

    @Column
    private String malt;

    @Column
    private List<String> comments;


    @Override
    public String toString() {
        return "Beer{" +
                "id='" + id + '\'' +
                ", style='" + style + '\'' +
                ", hop='" + hop + '\'' +
                ", malt='" + malt + '\'' +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Beer beer = (Beer) object;
        return Objects.equals(id, beer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static Beer of(Faker faker){
        var beer = faker.beer();
        Beer entity = new Beer();
        entity.hop = beer.hop();
        entity.malt = beer.malt();
        entity.style = beer.style();
        entity.id= UUID.randomUUID().toString();
        entity.comments  = List.of("comment1", "comment2");
        return entity;
    }

}