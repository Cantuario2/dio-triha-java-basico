package edu.dio.desafio.sudoku.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierService {

	private Map<EventEnum, List<EventListener>> listeners = new HashMap<EventEnum, List<EventListener>>() {
		private static final long serialVersionUID = 1L;

		{
			put(EventEnum.CLEAR_SPACE, new ArrayList<EventListener>());
		}
	};

	public void subscriber(final EventEnum eventType, EventListener listener) {
		List<EventListener> selectedListeners = listeners.get(eventType);
		selectedListeners.add(listener);
	}

	public void notify(final EventEnum eventType) {
		listeners.get(eventType).forEach(l -> l.update(eventType));
	}
}
