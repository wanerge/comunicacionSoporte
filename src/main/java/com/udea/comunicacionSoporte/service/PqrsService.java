package com.udea.comunicacionSoporte.service;

import com.udea.comunicacionSoporte.dto.ActualizarPqrsDTO;
import com.udea.comunicacionSoporte.dto.CrearPqrsDTO;
import com.udea.comunicacionSoporte.dto.PqrsDTO;
import com.udea.comunicacionSoporte.entity.*;
import com.udea.comunicacionSoporte.mapper.PqrsMapper;
import com.udea.comunicacionSoporte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PqrsService {

    private final PqrsRepository pqrsRepository;
    private final TipoPQRSRepository tipoPQRSRepository;
    private final EstadoPQRSRepository estadoPQRSRepository;
    private final ClienteRepository clienteRepository;
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public PqrsService(PqrsRepository pqrsRepository, TipoPQRSRepository tipoPQRSRepository,
                       EstadoPQRSRepository estadoPQRSRepository, ClienteRepository clienteRepository,
                       EmpleadoRepository empleadoRepository) {
        this.pqrsRepository = pqrsRepository;
        this.tipoPQRSRepository = tipoPQRSRepository;
        this.estadoPQRSRepository = estadoPQRSRepository;
        this.clienteRepository = clienteRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public List<PqrsDTO> listarTodas() {
        return pqrsRepository.findAll().stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PqrsDTO obtenerPorId(Long id) {
        return pqrsRepository.findById(id)
                .map(PqrsMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("PQRS no encontrada con ID: " + id));
    }

    public List<PqrsDTO> listarPorIdCliente(Long id) {
        return pqrsRepository.findByClienteIdCliente(id).stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PqrsDTO> listarPorIdGestor(Long id){
        return pqrsRepository.findByEmpleadoGestorIdEmpleado(id).stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PqrsDTO> obtenerPqrsSinGestores(){
        return pqrsRepository.findByEmpleadoGestorIsNull().stream()
                .map(PqrsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PqrsDTO crear(CrearPqrsDTO dto) {
        TipoPQRS tipo = tipoPQRSRepository.findById(dto.getIdTipoPqrs())
                .orElseThrow(() -> new RuntimeException("Tipo PQRS no encontrado"));
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        EstadoPQRS estado = estadoPQRSRepository.findByEstadoPqrs("Pendiente")
                .orElseThrow(() -> new RuntimeException("Estado PQRS no encontrado"));

        PQRS pqrs = new PQRS();
        pqrs.setTipoPqrs(tipo);
        pqrs.setCliente(cliente);
        pqrs.setAsuntoPqrs(dto.getAsuntoPqrs());
        pqrs.setDescripcionPqrs(dto.getDescripcionPqrs());
        pqrs.setEstadoPqrs(estado);
        pqrs.setFechaRadicacion(LocalDateTime.now());
        PQRS guardado = pqrsRepository.save(pqrs);
        return PqrsMapper.toDTO(guardado);
    }

    public PqrsDTO actualizar(Long idPqrs, ActualizarPqrsDTO dto) {
        PQRS existente = pqrsRepository.findById(idPqrs)
                .orElseThrow(() -> new RuntimeException("PQRS no encontrada con ID: " + idPqrs));

        TipoPQRS tipo = tipoPQRSRepository.findById(dto.getIdTipoPqrs())
                .orElseThrow(() -> new RuntimeException("Tipo PQRS no encontrado"));

        existente.setTipoPqrs(tipo);
        existente.setAsuntoPqrs(dto.getAsuntoPqrs());
        existente.setDescripcionPqrs(dto.getDescripcionPqrs());
        existente.setFechaModificacion(LocalDateTime.now());

        PQRS actualizado = pqrsRepository.save(existente);
        return PqrsMapper.toDTO(actualizado);
    }

    public PqrsDTO actualizarGestor(Long idPqrs, Long idGestor) {
        PQRS existente = pqrsRepository.findById(idPqrs)
                .orElseThrow(() -> new RuntimeException("PQRS no encontrada con ID: " + idPqrs));

        Empleado gestor = empleadoRepository.findById(idGestor)
                .orElseThrow(() -> new RuntimeException("Gestor no encontrado"));

        existente.setEmpleadoGestor(gestor);

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
