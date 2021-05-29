package datastructures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Stream;

public class MaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] topKCandidates(String fileName,int k) throws IOException {
		Stream<String> s = Files.lines(Paths.get(fileName));
		Set<Integer> voters = new HashSet<>();
		Map<Integer,Set<Integer>> candidateIdVoteCount = new HashMap();
		PriorityQueue<VoteEntry> pq =  new PriorityQueue<VoteEntry>((a,b) -> {
			return candidateIdVoteCount.getOrDefault(a.getCandidateId(),new HashSet()).size() - candidateIdVoteCount.getOrDefault(b.getCandidateId(),new HashSet()).size();
		});
		
		s.forEach(line -> {
			String[] values = line.split(",");
			int voterId = Integer.parseInt(values[0]);
			int candidateId = Integer.parseInt(values[1]);
			if(voters.contains(voterId)) {
				System.out.println("voterid:"+voterId+" is fraud");
			} else {
				VoteEntry v = new VoteEntry(candidateId);
				voters.add(voterId);
				Set<Integer> votersForCurrentCandidate = candidateIdVoteCount.getOrDefault(candidateId, new HashSet());
				votersForCurrentCandidate.add(voterId);
				v.setVoterIds(votersForCurrentCandidate);
				candidateIdVoteCount.put(candidateId, votersForCurrentCandidate);
				if(v.getVoterIds().size()>pq.peek().getVoterIds().size()) {
					if(pq.contains(v)) {
						pq.remove(v);
					}
					pq.add(v);
				}
				if(pq.size()>k) {
					VoteEntry v1 = pq.poll();
					candidateIdVoteCount.put(v1.getCandidateId(), candidateIdVoteCount.getOrDefault(v1.getCandidateId(),v1.getVoterIds()));
				}
			}
			
		});
		int[] topKCandidates = new int[k];
		for(int i=0;i<k;i++) {
			topKCandidates[k-i-1] = pq.poll().getCandidateId();
		}
		return topKCandidates;
	}

}

class VoteEntry {
	private Set<Integer> voterIds;
	private int candidateId;
	
	public VoteEntry(int candidateId) {
		this.candidateId = candidateId;
	}
	
	public Set<Integer> getVoterIds() {
		return voterIds;
	}

	public void setVoterIds(Set<Integer> voterIds) {
		this.voterIds = voterIds;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		VoteEntry v = (VoteEntry)obj;
		return this.candidateId==v.getCandidateId();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.candidateId;
	}
	
}
