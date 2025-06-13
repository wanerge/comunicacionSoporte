package com.udea.comunicacionSoporte.service;

import com.udea.comunicacionSoporte.dto.ActualizarNotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.dto.CrearNotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.dto.NotificacionInstitucionalDTO;
import com.udea.comunicacionSoporte.entity.Empleado;
import com.udea.comunicacionSoporte.entity.NotificacionInstitucional;
import com.udea.comunicacionSoporte.entity.TipoPublico;
import com.udea.comunicacionSoporte.mapper.NotificacionInstitucionalMapper;
import com.udea.comunicacionSoporte.repository.EmpleadoRepository;
import com.udea.comunicacionSoporte.repository.NotificacionInstitucionalRepository;
import com.udea.comunicacionSoporte.repository.TipoPublicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionInstitucionalService {

    @Autowired
    private NotificacionInstitucionalRepository notificacionRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private TipoPublicoRepository tipoPublicoRepository;

    @Autowired
    private NotificacionInstitucionalMapper mapper;

    public List<NotificacionInstitucionalDTO> listarTodas() {
        return notificacionRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public NotificacionInstitucionalDTO obtenerPorId(Long id) {
        NotificacionInstitucional entidad = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con ID: " + id));
        return mapper.toDTO(entidad);
    }

    public NotificacionInstitucionalDTO crear(CrearNotificacionInstitucionalDTO dto) {
        Empleado empleadoAdmin = empleadoRepository.findById(dto.getIdEmpleadoAdmin())
                .orElseThrow(() -> new RuntimeException("Empleado administrador no encontrado"));
        TipoPublico tipoPublico = tipoPublicoRepository.findById(dto.getIdTipoPublico())
                .orElseThrow(() -> new RuntimeException("Tipo de público no encontrado"));

        LocalDateTime fechaPublicacion = LocalDateTime.now();
        NotificacionInstitucional entidad = mapper.toEntity(dto, empleadoAdmin, tipoPublico, fechaPublicacion);
        NotificacionInstitucional guardada = notificacionRepository.save(entidad);
        return mapper.toDTO(guardada);
    }

    public NotificacionInstitucionalDTO actualizar(Long id, ActualizarNotificacionInstitucionalDTO dto) {
        NotificacionInstitucional existente = notificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con ID: " + id));

        TipoPublico tipoPublico = tipoPublicoRepository.findById(dto.getIdTipoPublico())
                .orElseThrow(() -> new RuntimeException("Tipo de público no encontrado"));

        existente.setTituloNotificacion(dto.getTituloNotificacion());
        existente.setContenidoNotificacion(dto.getContenidoNotificacion());
        existente.setFechaExpiracion(dto.getFechaExpiracion());
        existente.setTipoPublico(tipoPublico);

        NotificacionInstitucional actualizada = notificacionRepository.save(existente);
        return mapper.toDTO(actualizada);
    }

    public void eliminar(Long id) {
        if (!notificacionRepository.existsById(id)) {
            throw new RuntimeException("Notificación no encontrada con ID: " + id);
        }
        notificacionRepository.deleteById(id);
    }
}
