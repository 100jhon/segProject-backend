package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.DetalleTareaDto;
import com.example.segProjectBackend.Entity.DetalleTareaEntity;
import com.example.segProjectBackend.Mapper.DetalleTareaMapper;
import com.example.segProjectBackend.Repository.DetalleTareaRepository;
import com.example.segProjectBackend.Security.Service.SecurityUtilsService;
import com.example.segProjectBackend.Service.IDetalleTareaService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class DetalleTareaService implements IDetalleTareaService {

    private final SecurityUtilsService securityUtilsService;
    private final DetalleTareaRepository detalleTareaRepository;
    private final DetalleTareaMapper detalleTareaMapper;

    public DetalleTareaService(SecurityUtilsService securityUtilsService, DetalleTareaRepository detalleTareaRepository, DetalleTareaMapper detalleTareaMapper) {
        this.securityUtilsService = securityUtilsService;
        this.detalleTareaRepository = detalleTareaRepository;
        this.detalleTareaMapper = detalleTareaMapper;
    }

    @Override
    public DetalleTareaDto registrarDetalleTarea(DetalleTareaDto detalleTareaDto) {
        // ✅ Validar rol del usuario logueado
        if (!securityUtilsService.tieneRol("Desarrollador")) {
            throw new AccessDeniedException("Solo los desarrolladores pueden registrar detalles de tarea");
        }

        // ✅ Obtener el ID del usuario logueado
        Integer usuarioLogueadoId = securityUtilsService.getIdUsuarioLogueado();

        // ✅ Mapear DTO a Entity y asignar el usuario logueado
        DetalleTareaEntity detalleTareaEntity = detalleTareaMapper.toEntity(detalleTareaDto);
        detalleTareaEntity.setIdUsuario(usuarioLogueadoId);
        // ✅ Guardar en base de datos
        DetalleTareaEntity savedEntity = detalleTareaRepository.save(detalleTareaEntity);

        // ✅ Mapear Entity guardada a DTO usando el mapper
        return detalleTareaMapper.toDto(savedEntity);
    }
}
