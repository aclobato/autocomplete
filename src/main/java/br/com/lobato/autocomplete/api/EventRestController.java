package br.com.lobato.autocomplete.api;

import br.com.lobato.autocomplete.domain.Event;
import br.com.lobato.autocomplete.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EventRestController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/events")
    public List<Event> getAll() {
        List<Event> eventsList = new ArrayList<>();
        Iterable<Event> eventIterable = eventRepository.findAll();
        eventIterable.forEach(eventsList::add);
        return eventsList;
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void create(@RequestBody Event event) {
        eventRepository.save(event);
    }

    @RequestMapping("events/autocomplete")
    public List<String> autocomplete(@RequestParam String string)
    {
        List<String> suggestions = new ArrayList<>();
        if (string.length()>1) {
            Iterable<Event> eventIterable = eventRepository.findByEventContaining(string);
            eventIterable.forEach(event -> suggestions.add(event.getEvent()));
        }
        return suggestions;
    }
}
