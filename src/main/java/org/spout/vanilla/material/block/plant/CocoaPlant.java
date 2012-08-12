/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.material.block.plant;

import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.block.BlockFace;
import org.spout.api.material.block.BlockFaces;

import org.spout.vanilla.material.block.Plant;
import org.spout.vanilla.material.block.attachable.AbstractAttachable;
import org.spout.vanilla.material.block.solid.Log;

public class CocoaPlant extends AbstractAttachable implements Plant {
	public CocoaPlant(String name, int id) {
		super(name, id);
		this.setAttachable(BlockFaces.NESW);
	}

	@Override
	public boolean canAttachTo(Block block, BlockFace face) {
		return super.canAttachTo(block, face) && block.isMaterial(Log.JUNGLE);
	}

	@Override
	public void setAttachedFace(Block block, BlockFace attachedFace) {
		block.setDataField(0x3, BlockFaces.WNES.indexOf(attachedFace, 0));
	}

	@Override
	public BlockFace getAttachedFace(short data) {
		return BlockFaces.WNES.get(data & 0x3);
	}
}