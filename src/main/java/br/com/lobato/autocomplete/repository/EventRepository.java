package br.com.lobato.autocomplete.repository;

import br.com.lobato.autocomplete.domain.Event;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EventRepository extends ElasticsearchRepository<Event, String> {

    Iterable<Event> findByEventContaining(String event);
}
