package com.udea.comunicacionSoporte.service;

import com.udea.comunicacionSoporte.dto.PqrsDTO;
import com.udea.comunicacionSoporte.entity.*;
import com.udea.comunicacionSoporte.mapper.PqrsMapper;
import com.udea.comunicacionSoporte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PqrsService {

    @Autowired
    private PqrsRepository pqrsRepository;

    @Autowired
    private TipoPQRSRepository tipoPQRSRepository;

    @Autowired
    private EstadoPQRSRepository estadoPQRSRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<PqrsDTO> listarTodas() {
        return pqrsRepository.findAll().stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PqrsDTO> listarPorIdUsuario(Long id) {
        return pqrsRepository.findByClienteIdCliente(id).stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PqrsDTO obtenerPorId(Long id) {
        return pqrsRepository.findById(id)
                .map(PqrsMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("PQRS no encontrada con ID: " + id));
    }

    public PqrsDTO crear(PqrsDTO dto) {
        TipoPQRS tipo = tipoPQRSRepository.findById(dto.getIdTipoPqrs())
                .orElseThrow(() -> new RuntimeException("Tipo PQRS no encontrado"));
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Empleado gestor = empleadoRepository.findById(dto.getIdEmpleadoGestor())
                .orElseThrow(() -> new RuntimeException("Gestor no encontrado"));
        EstadoPQRS estado = estadoPQRSRepository.findById(dto.getIdEstadoPqrs())
                .orElseThrow(() -> new RuntimeException("Estado PQRS no encontrado"));

        LocalDateTime fechaRadicacion = LocalDateTime.now();
        dto.setFechaRadicacion(fechaRadicacion);
        PQRS pqrs = PqrsMapper.toEntity(dto, tipo, gestor, cliente, estado);
        PQRS guardado = pqrsRepository.save(pqrs);
        return PqrsMapper.toDTO(guardado);
    }

    public PqrsDTO actualizar(Long id, PqrsDTO dto) {
        PQRS existente = pqrsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PQRS no encontrada con ID: " + id));

        TipoPQRS tipo = tipoPQRSRepository.findById(dto.getIdTipoPqrs())
                .orElseThrow(() -> new RuntimeException("Tipo PQRS no encontrado"));
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Empleado gestor = empleadoRepository.findById(dto.getIdEmpleadoGestor())
                .orElseThrow(() -> new RuntimeException("Gestor no encontrado"));
        EstadoPQRS estado = estadoPQRSRepository.findById(dto.getIdEstadoPqrs())
                .orElseThrow(() -> new RuntimeException("Estado PQRS no encontrado"));

        existente.setTipoPqrs(tipo);
        existente.setCliente(cliente);
        existente.setEmpleadoGestor(gestor);
        existente.setEstadoPqrs(estado);
        existente.setAsuntoPqrs(dto.getAsuntoPqrs());
        existente.setDescripcionPqrs(dto.getDescripcionPqrs());
        existente.setFechaModificacion(dto.getFechaModificacion());
        existente.setFechaExpiracion(dto.getFechaExpiracion());

        PQRS actualizado = pqrsRepository.save(existente);
        return PqrsMapper.toDTO(actualizado);
    }

    public void eliminar(Long id) {
        if (!pqrsRepository.existsById(id)) {
            throw new RuntimeException("PQRS no encontrada con ID: " + id);
        }
        pqrsRepository.deleteById(id);
    }
}
